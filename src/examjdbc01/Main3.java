package examjdbc01;

import java.util.ArrayList;
import java.util.Date;

public class Main3 {
    public static void main(String[] args){
        MemberService memberService = new MemberService(new MemberDao());

        //C (insert)
        MemberVo vo1 = new MemberVo(1, "test11", "1234", "nick11");
        vo1.setRegdate(new Date());
        MemberVo vo2 = new MemberVo(2, "test22", "1234", "nick22");
        vo2.setRegdate(new Date());
        MemberVo vo3 = new MemberVo(3, "test33", "1234", "nick33");
        vo3.setRegdate(new Date());
        MemberVo vo4 = new MemberVo(4, "test44", "1234", "nick44");
        vo4.setRegdate(new Date());

        memberService.regist(vo1);
        memberService.regist(vo2);
        memberService.regist(vo3);
        memberService.regist(vo4);

        System.out.println("<저장 완료!>");
        System.out.println("<출력 결과>");
        ArrayList<MemberVo> ls = memberService.listAll();
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        //R (select)

        System.out.println("<단일 조회!>");
        MemberVo tmp = memberService.read(1);
        System.out.println("<출력 결과>");
        System.out.println(tmp);
        System.out.println("---------------------");

        System.out.println("<전체 조회!>");
        System.out.println("<출력 결과>");
        ls = memberService.listAll();
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        //U (update)
        System.out.println("<데이터 수정!>");
        tmp = memberService.read(1);
        if(tmp != null){
            tmp.setNickName("John");
            tmp.setMemberPw("4321");
            tmp.setRegdate(new Date());
        }
        memberService.edit(tmp);

        System.out.println("<출력 결과>");
        ls = memberService.listAll();
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        //D (delete)
        System.out.println("<단일 삭제!>");
        memberService.remove(2);
        System.out.println("<출력 결과>");
        ls = memberService.listAll();
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        System.out.println("<전체 삭제!>");
        memberService.removeAll();
        System.out.println("<출력 결과>");
        ls = memberService.listAll();
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");
    }
}