package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Map<Integer, MemberVo> db = new HashMap<>();

        //C (insert)
        MemberVo vo1 = new MemberVo(1, "test1", "1234", "nick1", new Date());
        MemberVo vo2 = new MemberVo(2, "test2", "1234", "nick2", new Date());
        MemberVo vo3 = new MemberVo(3, "test3", "1234", "nick3", new Date());
        MemberVo vo4 = new MemberVo(4, "test4", "1234", "nick4", new Date());

        db.put(1, vo1);
        db.put(2, vo2);
        db.put(3, vo3);
        db.put(4, vo4);

        System.out.println("<저장 완료!>");
        System.out.println("<출력 결과>");
        ArrayList<MemberVo> ls = new ArrayList<>(db.values());
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        //R (select)

        System.out.println("<단일 조회!>");
        MemberVo tmp = null;
        tmp = db.get(1);
        System.out.println("<출력 결과>");
        System.out.println(tmp);
        System.out.println("---------------------");

        System.out.println("<전체 조회!>");
        System.out.println("<출력 결과>");
        ls = new ArrayList<>(db.values());
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        //U (update)
        System.out.println("<데이터 수정!>");
        tmp = null;
        tmp = db.get(1);
        if(tmp != null){
            tmp.setNickName("John");
            tmp.setMemberPw("4321");
            tmp.setRegdate(new Date());
        }
        db.put(1, tmp);

        System.out.println("<출력 결과>");
        ls = new ArrayList<>(db.values());
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        //D (delete)
        System.out.println("<단일 삭제!>");
        db.remove(2);
        System.out.println("<출력 결과>");
        ls = new ArrayList<>(db.values());
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");

        System.out.println("<전체 삭제!>");
        db.clear();
        System.out.println("<출력 결과>");
        ls = new ArrayList<>(db.values());
        for(MemberVo vo : ls){
            System.out.println(vo);
        }
        System.out.println("---------------------");
    }
}
