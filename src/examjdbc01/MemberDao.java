package examjdbc01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    // db 역할
    private Map<Integer, MemberVo> db = new HashMap<>();

    // C
    public void insertMember(MemberVo vo){
        db.put(vo.getNum(), vo);
    }

    // R
    // 단일 선택
    public MemberVo selectMember(int num){
        return db.get(num);
    }
    // 전체 선택
    public ArrayList<MemberVo> selectMemberAll(){
        return new ArrayList<MemberVo>(db.values());
    }

    // U
    public void updateMember(MemberVo vo){
        db.put(vo.getNum(), vo);
    }

    // D
    // 단일 삭제
    public void deleteMember(int num){
        db.remove(num);
    }
    // 전체 삭제
    public void deleteMemberAll(){
        db.clear();
    }
}
