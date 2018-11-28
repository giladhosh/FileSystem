import java.util.Collection;
import java.util.HashMap;

public class Directory extends FileSystemComponent {
	
	private HashMap<String,FileSystemComponent> subComponentsMap;
	
	public Directory(String name) {
		super(name);
		subComponentsMap = new HashMap<String, FileSystemComponent>();
	}
	
	public void addComponent(FileSystemComponent component) {
		subComponentsMap.put(component.getName(), component);
	}
	
	/**
	 * Display all properties
	 * @param depth - the depth of the directory in its' hierarchy
	 */
	@Override
	public void printComponents(int depth) {
		Collection<FileSystemComponent> subCollection = getSubComponentsMap().values();
		String spaces = String.format("%"+ (depth*4) +"s", "");
		System.out.println(spaces + "Directory: Name = " + this.getName() + " , Number of sub-components = " + subCollection.size() + " , creation date = " + this.getCreateDate()); 
		subCollection.forEach(component -> component.printComponents(depth+1));
	}

	public HashMap<String,FileSystemComponent> getSubComponentsMap() {
		return subComponentsMap;
	}
}
