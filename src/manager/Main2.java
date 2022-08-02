package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args){
        MemberDao memberDao = new MemberDao();

        //C (insert)
        MemberVo vo1 = new MemberVo(1, "test1", "1234", "nick1", new Date());
        MemberVo vo2 = new MemberVo(2, "test2", "1234", "nick2", new Date());
        MemberVo vo3 = new MemberVo(3, "test3", "1234", "nick3", new Date());
        MemberVo vo4 = new MemberVo(4, "test4", "1234", "nick4", new Date());

        memberDao.insertMember(vo1);
        memberDao.insertMember(vo2);
        memberDao.insertMember(vo3);
        memberDao.insertMember(vo4);

        System.out.println("<저장 완료!>");
        System.out.println("<출력 결과>");
        ArrayList<MemberVo> ls = memberDao.selectMemberAll();
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        //R (select)

        System.out.println("<단일 조회!>");
        MemberVo tmp = memberDao.selectMember(1);
        System.out.println("<출력 결과>");
        System.out.println(tmp);
        System.out.println("---------------------");

        System.out.println("<전체 조회!>");
        System.out.println("<출력 결과>");
        ls = memberDao.selectMemberAll();
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        //U (update)
        System.out.println("<데이터 수정!>");
        tmp = memberDao.selectMember(1);
        if(tmp != null){
            tmp.setNickName("John");
            tmp.setMemberPw("4321");
            tmp.setRegdate(new Date());
        }
        memberDao.updateMember(tmp);

        System.out.println("<출력 결과>");
        ls = memberDao.selectMemberAll();
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        //D (delete)
        System.out.println("<단일 삭제!>");
        memberDao.deleteMember(2);
        System.out.println("<출력 결과>");
        ls = memberDao.selectMemberAll();
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        System.out.println("<전체 삭제!>");
        memberDao.deleteMemberAll();
        System.out.println("<출력 결과>");
        ls = memberDao.selectMemberAll();
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");
    }
}