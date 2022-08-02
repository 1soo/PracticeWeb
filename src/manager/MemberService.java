package manager;

import java.util.ArrayList;

public class MemberService {
    private MemberDao memberDao;

    public MemberService(MemberDao memberDao){
        this.memberDao =  memberDao;
    }

    // 등록하기
    public boolean regist(MemberVo vo){
        if(memberDao.selectMember(vo.getNum()) == null){
            memberDao.insertMember(vo);
            return true;
        }
        return false;
    }

    // 조회하기
    public MemberVo read(int num){
        return memberDao.selectMember(num);
    }

    // 전체조회하기
    public ArrayList<MemberVo> listAll(){
        return memberDao.selectMemberAll();
    }

    // 수정하기
    public void edit(MemberVo vo){
        MemberVo searchMember = memberDao.selectMember(vo.getNum());
        if(searchMember.getMemberPw().equals(vo.getMemberPw())){
            memberDao.updateMember(vo);
        }
    }

    // 탈퇴하기
    public void remove(int num){
        memberDao.deleteMember(num);
    }

    public void removeAll(){
        memberDao.deleteMemberAll();
    }
}
