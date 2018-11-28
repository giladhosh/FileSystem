
public class File extends FileSystemComponent {
	private long size;

	public File(String name, long size) {
		super(name);
		this.size = size; 
	}

	public long getSize() {
		return size;
	}

	/**
	 * Display all file properties
	 * @param depth - the depth of the directory in its' hierarchy
	 */
	@Override
	public void printComponents(int depth) {
		String hierarchyIndentation = String.format("%"+ (depth*4) +"s", "");
		System.out.println( hierarchyIndentation + "File: Name = " + this.getName() + " , size = " + this.getSize() + " , creation date = " + this.getCreateDate());
	}
	
}
