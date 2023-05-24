package com.sparta.petplace.member.repository;

import com.sparta.petplace.member.entity.Member;
import com.sparta.petplace.member.entity.MemberHistory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MemberHistoryRepositorys {
    @PersistenceContext
    private EntityManager entityManager;

    public List<MemberHistory> findTop3ByMemberOrderByCreatedAtDesc(Member member){
        String jpql = "SELECT mh FROM MemberHistory mh WHERE mh.member = :member";
        return entityManager.createQuery(jpql,MemberHistory.class)
                .setParameter("member",member)
                .setMaxResults(3)
                .getResultList();
    }

}
