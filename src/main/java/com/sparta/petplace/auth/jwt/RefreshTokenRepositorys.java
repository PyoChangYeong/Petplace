package com.sparta.petplace.auth.jwt;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RefreshTokenRepositorys {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(RefreshToken refreshToken){
        entityManager.persist(refreshToken);
    }

    public List<RefreshToken> findAllByMemberId(Long id){
        String jpql = "SELECT rt FROM RefreshToken rt WHERE rt.id = :memberId";
        return entityManager.createQuery(jpql,RefreshToken.class)
                .setParameter("memberId",id)
                .getResultList();
    }





}
