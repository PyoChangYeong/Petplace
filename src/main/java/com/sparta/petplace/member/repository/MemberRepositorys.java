package com.sparta.petplace.member.repository;

import com.sparta.petplace.member.entity.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
@Transactional
public class MemberRepositorys {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Member member){
        entityManager.persist(member);
    }

    public Optional<Member> findByEmail(String email){
        String jpql = "SELECT m FROM Member m WHERE m.email = :email";
        return entityManager.createQuery(jpql,Member.class)
                .setParameter("email",email)
                .getResultList()
                .stream()
                .findFirst();
    }

    public Optional<Member> existsByBusiness(String business){
        String jpql = "SELECT m FROM Member m WHERE m.business =:business";
        return entityManager.createQuery(jpql,Member.class)
                .setParameter("business",business)
                .getResultList()
                .stream()
                .findFirst();
    }
    public boolean existsByEmail(String email){
        String jpql = "SELECT COUNT(m) > 0 FROM Member m WHERE m.email = :email";
        return entityManager.createQuery(jpql, Boolean.class)
                .setParameter("email",email)
                .getSingleResult();
    }

    public Optional<Member> findMemberById(Long memberId){
        String jpql = "SELECT m FROM Member m WHERE m.id = :memberId";
        return entityManager.createQuery(jpql,Member.class)
                .setParameter("memberId",memberId)
                .getResultStream()
                .findFirst();
    }

}
