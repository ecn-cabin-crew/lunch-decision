package ld.domain.lunch_group;

public class LunchGroup {

	public String[] membersId;
	
	public LunchGroup(String[] membersId) {
		super();
		this.membersId = membersId;
	}

	public void create() {
		System.out.println("hello new lunch group");
	}
	
	public String[] getMembersId() {
		return membersId;
	}
	
}
