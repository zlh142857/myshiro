package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 11:08
 *@功能:
 */

import com.hx.dao.UserInfoRepository;
import com.hx.model.UserInfo;
import com.hx.service.UserInfoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserInfoRepository userInfoRepository;
   /* private UserInfoRepository userInfoRepository = new UserInfoRepository() {
        @Override
        public UserInfo findByUsername(String username) {
            return findByUsername(username);
        }

        @Override
        public <S extends UserInfo> S save(S s) {
            return null;
        }

        @Override
        public <S extends UserInfo> Iterable<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Optional<UserInfo> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public Iterable<UserInfo> findAll() {
            return null;
        }

        @Override
        public Iterable<UserInfo> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(UserInfo userInfo) {

        }

        @Override
        public void deleteAll(Iterable<? extends UserInfo> iterable) {

        }

        @Override
        public void deleteAll() {

        }
    };*/

    @Override
    public UserInfo findByUsername(String username) {
        try{
            return userInfoRepository.findByUsername(username);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
