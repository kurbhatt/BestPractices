package org.base;

/**
 * Created by Keyur on 6/15/2016.
 */

public class BaseClass {

	private Integer member1;
	private Integer member2;

	public BaseClass() {
	}

	public BaseClass(Integer member1, Integer member2) {
		this.member1 = member1;
		this.member2 = member2;
	}

	public Integer getMember1() {
		return member1;
	}

	public void setMember1(Integer member1) {
		this.member1 = member1;
	}

	public Integer getMember2() {
		return member2;
	}

	public void setMember2(Integer member2) {
		this.member2 = member2;
	}
}
