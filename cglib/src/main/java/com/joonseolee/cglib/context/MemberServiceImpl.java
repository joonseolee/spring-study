package com.joonseolee.cglib.context;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberServiceImpl implements MemberService {
    @Override
    public String registration() {
        log.info("난 지금 registration 로직처리중..");
        return "registration method in MemberServiceImpl";
    }

    @Override
    public String getMember() {
        log.info("난 지금 getMember 로직처리중..");
        return "getMember method in MemberServiceImpl";
    }
}
