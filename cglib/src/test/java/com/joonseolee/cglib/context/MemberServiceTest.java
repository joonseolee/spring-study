package com.joonseolee.cglib.context;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MemberServiceTest {

    @Test
    public void whenStartingServer_thenIsGenerateObjectByCglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MemberServiceImpl.class);
        enhancer.setCallback(NoOp.INSTANCE);

        MemberService memberService = (MemberService) enhancer.create();
        String text1 = memberService.getMember();
        String text2 = memberService.registration();

        assertThat(text1, is("getMember method in MemberServiceImpl"));
        assertThat(text2, is("registration method in MemberServiceImpl"));
    }

    @Test
    public void whenStartingServer_thenIsGenerateObjectByCglibWithCallback() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MemberServiceImpl.class);
        enhancer.setCallback(new MethodCallLogInterceptor());

        MemberService memberService = (MemberService) enhancer.create();
        String text1 = memberService.getMember();
        String text2 = memberService.registration();

        assertThat(text1, is("getMember method in MemberServiceImpl"));
        assertThat(text2, is("registration method in MemberServiceImpl"));
    }

    @Test
    public void whenStartingServer_thenIsGenerateObjectByCglibWithReverseCallback() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MemberServiceImpl.class);
        enhancer.setCallback(new ReverseMethodCallInterceptor());

        MemberService memberService = (MemberService) enhancer.create();
        String text1 = memberService.getMember();
        String text2 = memberService.registration();

        assertThat(text1, is("getMember method in MemberServiceImpl"));
        assertThat(text2, is("none"));
    }

    @Test
    public void whenStartingServer_thenIsGenerateObjectByCglibWithCallbackFilter() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MemberServiceImpl.class);
        Callback[] callbacks = new Callback[] {
                new ReverseMethodCallInterceptor(),
                new MethodCallLogInterceptor()};
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(new MemberServiceCallbackFilter());

        MemberService memberService = (MemberService) enhancer.create();
        String text1 = memberService.getMember();
        String text2 = memberService.registration();

        assertThat(text1, is("getMember method in MemberServiceImpl"));
        assertThat(text2, is("none"));
    }
}
