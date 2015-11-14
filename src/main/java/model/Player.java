package model;

public class Player {
	private long id;
	private String name;
	private String team;
	private String nationality;
	
	public Player() {
		id = 0;
	}
	
	public Player(long id, String name, String team, String nationality) {
		this.id = id;
		this.name = name;
		this.team = team;
		this.nationality = nationality;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null) 
			return false;
		if (!(obj instanceof Player))
			return false;
		Player other = (Player) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", team=" + team
				+ ", nationality" + nationality + "]";
	}
}
