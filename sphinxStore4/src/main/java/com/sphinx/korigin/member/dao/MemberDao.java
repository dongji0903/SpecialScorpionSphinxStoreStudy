package com.sphinx.korigin.member.dao;

import java.sql.Timestamp;
import java.util.List;

import com.sphinx.korigin.member.domain.Member;
import com.sphinx.korigin.member.domain.pointLog;

public interface MemberDao {
	public String insertMember(Member customer);

	public Member selectMember(String id,String pwd);

	public int countByMemberId(String id);

	public int findPoint(String id);

	public Integer getMaxCount(String id);

	public List<pointLog> getPageLogList(int offset, int count, String id);

	public List<pointLog> getPointLog(String id);

	public String findLevel(String id);

	public int findExp(String id);

	public boolean isExistingNickName(String nickName);

	public List<Member> findAllMembers();

	public List<Member> findAllAdministrators();

	public void modifyMember(Member m);

	public void deleteMember(String id);

	public void updatePoint(String id, int point);

	public void updateLevel(String id, String level);

	public void updateExp(String id, int exp);

	void addPointLog(String id, String point, String totalPoint,
			Timestamp date);

	void reducePointLog(String id, String point, String totalPoint,
			Timestamp date);
}
