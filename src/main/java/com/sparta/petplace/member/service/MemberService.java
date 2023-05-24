package com.sparta.petplace.member.service;

import com.sparta.petplace.auth.jwt.*;
import com.sparta.petplace.common.ApiResponseDto;
import com.sparta.petplace.common.ResponseUtils;
import com.sparta.petplace.common.SuccessResponse;
import com.sparta.petplace.exception.CustomException;
import com.sparta.petplace.exception.Error;
import com.sparta.petplace.member.dto.BusinessSignupRequestDto;
import com.sparta.petplace.member.dto.LoginRequestDto;
import com.sparta.petplace.member.dto.LoginResponseDto;
import com.sparta.petplace.member.dto.SignupRequestDto;
import com.sparta.petplace.member.entity.LoginType;
import com.sparta.petplace.member.entity.Member;
import com.sparta.petplace.member.entity.MemberHistory;
import com.sparta.petplace.member.repository.MemberHistoryRepository;
import com.sparta.petplace.member.repository.MemberHistoryRepositorys;
import com.sparta.petplace.member.repository.MemberRepository;
import com.sparta.petplace.member.repository.MemberRepositorys;
import com.sparta.petplace.post.ResponseDto.HistoryPostResponseDto;
import com.sparta.petplace.post.entity.Post;
import com.sparta.petplace.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepositorys memberRepositorys;
    private final RefreshTokenRepositorys refreshTokenRepositorys;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final MemberHistoryRepositorys memberHistoryRepositorys;
    private final PostRepository postRepository;


    //      일반유저 회원가입기능(JPQL)
    @Transactional
    public ApiResponseDto<SuccessResponse> signup(SignupRequestDto signupRequestDto){
        String email = signupRequestDto.getEmail();
        boolean emailExists = memberRepositorys.existsByEmail(email);
        if(emailExists){
            throw new CustomException(Error.DUPLICATED_EMAIL);
        }
        Member member = Member.builder()
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .nickname(signupRequestDto.getNickname())
                .email(email)
                .loginType(LoginType.USER)
                .build();
        memberRepositorys.save(member);
        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "회원가입 성공"));
    }



    // 일반유저 회원가입기능
//    @Transactional
//    public ApiResponseDto<SuccessResponse> signup(SignupRequestDto signupRequestDto) {
//        // 이메일 중복 검사
//        memberCheck(signupRequestDto.getEmail());
//        memberRepository.save(Member.builder()
//                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
//                .nickname(signupRequestDto.getNickname())
//                .email(signupRequestDto.getEmail())
//                .loginType(LoginType.USER)
//                .build());
//        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "회원가입 성공"));
//    }


    //    사업자 회원가입 기능 (JPQL)
    @Transactional
    public ApiResponseDto<SuccessResponse>businessSignup(BusinessSignupRequestDto signupRequestDto){
        String email = signupRequestDto.getEmail();
        boolean emailExists = memberRepositorys.existsByEmail(email);
        if(emailExists){
            throw new CustomException(Error.DUPLICATED_EMAIL);
        }
        Member member = Member.builder()
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .nickname(signupRequestDto.getNickname())
                .email(email)
                .business(signupRequestDto.getBusiness())
                .loginType(LoginType.BUSINESS)
                .build();
        memberRepositorys.save(member);
        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "회원가입 완료"));
    }


    // 사업자 회원가입 기능
//    @Transactional
//    public ApiResponseDto<SuccessResponse> businessSignup(BusinessSignupRequestDto signupRequestDto) {
//        //  이메일 중복 검사
//        memberCheck(signupRequestDto.getEmail());
//        memberRepository.save(Member.builder()
//                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
//                .nickname(signupRequestDto.getNickname())
//                .email(signupRequestDto.getEmail())
//                .business(signupRequestDto.getBusiness())
//                .loginType(LoginType.BUSINESS)
//                .build());
//        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "회원가입 성공"));
//    }

    //    로그인 (JPQL)
    @Transactional
    public ApiResponseDto<LoginResponseDto>login(LoginRequestDto requestDto,HttpServletResponse response){
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        Optional<Member> findMember = memberRepositorys.findByEmail(email);
        if(findMember.isEmpty()){
            throw new CustomException(Error.NOT_EXIST_USER);
        }
        if(!passwordEncoder.matches(password, findMember.get().getPassword())){
            throw new CustomException(Error.PASSWORD_WRONG);
        }
        String memberId = String.valueOf(findMember.get().getId());
        TokenDto tokenDto = jwtUtil.createAllToken(email, memberId);
        List<RefreshToken> refreshToken = refreshTokenRepositorys.findAllByMemberId(Long.valueOf(memberId));
        if(refreshToken.isEmpty()){
            RefreshToken newToken = new RefreshToken(tokenDto.getRefresh_Token(),memberId);
            refreshTokenRepositorys.save(newToken);
        }else {
            RefreshToken refreshToken1 = refreshToken.get(0);
            refreshToken1.updateToken(tokenDto.getRefresh_Token());
            refreshTokenRepositorys.save(refreshToken1);
        }
        jwtUtil.setHeader(response,tokenDto);
        String img = findMember.get().getImage();

        LoginResponseDto loginResponseDto = LoginResponseDto.builder()
                .loginType(findMember.get().getLoginType())
                .nickname(findMember.get().getNickname())
                .img(img)
                .build();

        return ResponseUtils.ok(loginResponseDto);

    }


    // 로그인
//    @Transactional
//    public ApiResponseDto<LoginResponseDto> login(LoginRequestDto requestDto, HttpServletResponse response) {
//        String email = requestDto.getEmail();
//        String password = requestDto.getPassword();
//
//        Optional<Member> findMember = memberRepository.findByEmail(email);
//
//        if (findMember.isEmpty()) {
//            throw new CustomException(Error.NOT_EXIST_USER);
//        }
//        if (!passwordEncoder.matches(password, findMember.get().getPassword())) {
//            throw new CustomException(Error.PASSWORD_WRONG);
//        }
//        // Token 생성
//        TokenDto tokenDto = jwtUtil.createAllToken(email);
//        Optional<RefreshToken> refreshToken = refreshTokenRepository.findAllByMemberId(email);
//        // Token 이 있을 경우 기존 Token 을 update
//        if (refreshToken.isPresent()) {
//            refreshTokenRepository.save(refreshToken.get().updateToken(tokenDto.getRefresh_Token()));
//        // Token 이 없을 경우 새로운 Token 을 생성
//        } else {
//            RefreshToken newToken = new RefreshToken(tokenDto.getRefresh_Token(), email);
//            refreshTokenRepository.save(newToken);
//        }
//
//        jwtUtil.setHeader(response, tokenDto);
//        String img = findMember.get().getImage();
//
//        LoginResponseDto loginResponseDto = LoginResponseDto.builder()
//                .loginType(findMember.get().getLoginType())
//                .nickname(findMember.get().getNickname())
//                .img(img)
//                .build();
//
//        return ResponseUtils.ok(loginResponseDto);
//    }

    //    메일 중복 검사 (JPQL)
    @Transactional(readOnly = true)
    public ApiResponseDto<SuccessResponse> memberCheck(String email){
        boolean emailExists = memberRepositorys.existsByEmail(email);
        if(emailExists){
            throw new CustomException(Error.DUPLICATED_EMAIL);
        }
        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "사용 가능"));
    }


    // 메일 중복 검사
//    @Transactional(readOnly = true)
//    public ApiResponseDto<SuccessResponse> memberCheck(String email) {
//        Optional<Member> findMember = memberRepository.findByEmail(email);
//        if (findMember.isPresent()) {
//            throw new CustomException(Error.DUPLICATED_EMAIL);
//        }
//        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "사용 가능한 계정입니다."));
//    }


    //    사업자 번호 중복검사 (JPQL)
    @Transactional(readOnly = true)
    public ApiResponseDto<SuccessResponse> businessMemberCheck(String business){
        Optional<Member> findMember = memberRepositorys.existsByBusiness(business);
        if(findMember.isPresent()){
            throw new CustomException(Error.DUPLICATED_BUSINESS);
        }
        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "사용가능"));
    }



    // 사업자 번호 중복검사
//    @Transactional(readOnly = true)
//    public ApiResponseDto<SuccessResponse> businessMemberCheck(String business) {
//        Optional<Member> findMember = memberRepository.findByBusiness(business);
//        if (findMember.isPresent()) {
//            throw new CustomException(Error.DUPLICATED_BUSINESS);
//        }
//        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "가입이 가능합니다.."));
//    }


    //    Refresh 토큰으로 AccessToken 생성 (JPQL)
    public ApiResponseDto<SuccessResponse> issueToken(HttpServletRequest request,HttpServletResponse response){
        String refreshToken = jwtUtil.resolveToken(request,"Refresh");
        if(!jwtUtil.refreshTokenValidation(refreshToken)){
            throw new CustomException(Error.WRONG_TOKEN);
        }
        Optional<Member> member = memberRepositorys.findMemberById(Long.valueOf(jwtUtil.getUserId(refreshToken)));
        String email = null;
        if(member.isPresent()){
            email = member.get().getEmail();
        }
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(email));
        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "토큰 갱신 성공"));
    }


    // Refresh 토큰으로 AccessToken 을 생성
//    public ApiResponseDto<SuccessResponse> issueToken(HttpServletRequest request, HttpServletResponse response) {
//        String refreshToken = jwtUtil.resolveToken(request, "Refresh");
//        if (!jwtUtil.refreshTokenValidation(refreshToken)) {
//            throw new CustomException(Error.WRONG_TOKEN);
//        }
//        Optional<Member> member = memberRepository.findById(Long.valueOf(jwtUtil.getUserId(refreshToken)));
//        String email = null;
//        if (member.isPresent()) {
//            email = member.get().getEmail();
//        }
//
//        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(email));
//        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "토큰 갱신 성공."));
//    }

//              ========================================= 밑에부터  ===================================

    //내가 본 게시물 조회하기 (3개)
    @Transactional
    public List<HistoryPostResponseDto> getMemberHistory(Member member) {
        //  findTop3ByMemberOrderByCreatedAtDesc : Top3 3개
        List<MemberHistory> memberHistories = memberHistoryRepositorys.findTop3ByMemberOrderByCreatedAtDesc(member);
        List<HistoryPostResponseDto> historyPostResponseDtoList = new ArrayList<>();

        for (MemberHistory history : memberHistories) {
            Post post = history.getPost();
            HistoryPostResponseDto historyPostResponseDto = getPostIfoNoHistory(post.getId());
            historyPostResponseDtoList.add(historyPostResponseDto);
        }
        return historyPostResponseDtoList;
    }


    // 히스토리 게시글 불러오기
    private HistoryPostResponseDto getPostIfoNoHistory(Long post_id) {
        Post posts = postRepository.findById(post_id).orElseThrow(
                () -> new CustomException(Error.NOT_FOUND_POST)
        );
        return HistoryPostResponseDto.of(posts);
    }


}
