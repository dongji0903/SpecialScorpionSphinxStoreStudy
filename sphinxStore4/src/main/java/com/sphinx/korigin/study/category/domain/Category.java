package com.sphinx.korigin.study.category.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable, Comparable<Category> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8467668763588365030L;
	private String cid;
	private String parent; // DB엔 부모값만 있는데 여기도 부모값만 있으면 아래로 탐색이 불능.
	private String title;
	private List<String> children;

	public void addChild(String child) {
		if (children == null) {
			children = new ArrayList<>();
			children.add(child);
		} else if (!children.contains(child)) {
			children.add(child);
		}
	}

	public void removeChild(String child) {
		if (children != null && children.contains(child)) {
			children.remove(child);
		}
	}

	public String getCid() {
		return cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category(String title) {
		super();
		this.title = title;
	}

	public Category(String title, List<String> children) {
		super();
		this.title = title;
		this.setChildren(children);
	}

	public Category(String cid, String title, List<String> children) {
		super();
		this.setCid(cid);
		this.title = title;
		this.setChildren(children);
	}

	public Category(String cid, String parentCid, String title,
			List<String> children) {
		super();
		this.setCid(cid);
		this.parent = parentCid;
		this.title = title;
		this.children = children;
	}

	@Override
	public int compareTo(Category o) {
		int cidVal1 = Integer.valueOf(getCid().substring(1));
		int cidVal2 = Integer.valueOf(o.getCid().substring(1));
		if (cidVal1 > cidVal2) {
			return 1;
		} else if (cidVal1 < cidVal2) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getCid() == null) ? 0 : getCid().hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (getCid() == null) {
			if (other.getCid() != null)
				return false;
		} else if (!getCid().equals(other.getCid()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [cid=" + getCid() + ", parent=" + parent + ", title="
				+ title + ", children=" + children + "]";
	}

	public List<String> getChildren() {
		return children;
	}

	public void setChildren(List<String> children) {
		this.children = children;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parentCid) {
		this.parent = parentCid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
