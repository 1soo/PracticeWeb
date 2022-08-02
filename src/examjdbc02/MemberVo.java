package examjdbc02;

import java.util.Date;

public class MemberVo {
    private int num;
    private String memberId;
    private String memberPw;
    private String nickName;
    private Date regDate;

    public MemberVo() {}

    public MemberVo(int num, String memberId, String memberPw, String nickName, Date regDate) {
        this.num = num;
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.nickName = nickName;
        this.regDate = regDate;
    }

    public int getNum() {
        return num;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public String getNickName() {
        return nickName;
    }

    public Date getRegdate() {
        return regDate;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setRegdate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "MemberVo{" +
                "num=" + num +
                ", memberId='" + memberId + '\'' +
                ", memberPw='" + memberPw + '\'' +
                ", nickName='" + nickName + '\'' +
                ", regdate=" + regDate +
                '}';
    }
}
