package com.sphinx.korigin.study.study.dao.exam;

public interface SheetFormDao {
	public void addLink(String sid, String eid);

	public void removeLinks(String sid); // 해당 시트의 form을 모두 끊음

	public String findFormIdOfSheet(String sid); // 해당 시트의 form을 모두 가져옴
}
