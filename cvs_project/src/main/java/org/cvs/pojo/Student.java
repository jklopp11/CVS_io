package org.cvs.pojo;

public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private String profession;
	private String sclass;
	private String qq;
	private String wechat;
	private Integer phone;
	private String home;
	private String hobby;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Student() {

	}

	public Student(Integer id, String name, Integer age, String profession, String sclass, String qq, String wechat,
			Integer phone, String home, String hobby) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.profession = profession;
		this.sclass = sclass;
		this.qq = qq;
		this.wechat = wechat;
		this.phone = phone;
		this.home = home;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", profession=" + profession + ", sclass="
				+ sclass + ", qq=" + qq + ", wechat=" + wechat + ", phone=" + phone + ", home=" + home + ", hobby="
				+ hobby + "]";
	}

}
