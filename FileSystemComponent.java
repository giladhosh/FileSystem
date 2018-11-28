import java.util.Date;

public abstract class FileSystemComponent {

	private String name;
	private Date createDate;
	
	public FileSystemComponent(String name) {
		this.name = name;
		this.createDate = new Date();
	}
	
	public String getName() {
		return name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public abstract void printComponents(int depth);
}
