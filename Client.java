import java.util.HashMap;

public class Client {

	private static String ROOT_NAME = "root";
	private Directory fs = null;
	private HashMap<String, Directory> fsMap = null;
	private HashMap<String, String> fileSystemParentsDirectoriesMap = null;
	
	public void initFileSystem() {
		this.fs = new Directory(ROOT_NAME);
		this.fsMap =  new HashMap<String, Directory>();
		this.fileSystemParentsDirectoriesMap = new HashMap<String, String>();
		this.fsMap.put(ROOT_NAME, this.fs);
	}
	
	public FileSystemComponent getFileSystem() {
		if(fs == null) {
			initFileSystem();
		}
		return fs;
	}

	/**
	 * Adds new File under the Directory branch
	 * @param parentDirName - name of the directory to add to.
	 * @param fileName
	 * @param fileSize
	 */
	public void addFile(String parentDirName, String fileName, Integer fileSize) {
		File file = new File(fileName, fileSize);
		fsMap.get(parentDirName).addComponent(file);
		fileSystemParentsDirectoriesMap.put(fileName , parentDirName);
	}
	
	/**
	 * Adds new Directory under the parent Directory
	 * @param parentDirName - - name of the directory to add to.
	 * @param dirName - name of the directory to add.
	 */
	public void addDir(String parentDirName, String dirName) {
		Directory dirToAdd = new Directory(dirName);
		fsMap.put(dirName, dirToAdd);//Add to Map
		fsMap.get(parentDirName).addComponent(dirToAdd);//Add to Directory subComponents
		fileSystemParentsDirectoriesMap.put(dirName , parentDirName);
	}
	
	/**
	 * Deletes the Directory or the File with this name
	 * @param name - name of the file or directory  to delete
	 */
	public void delete (String name) {
		fsMap.remove(name);
		String parentDirName = fileSystemParentsDirectoriesMap.get(name);
		fsMap.get(parentDirName).getSubComponentsMap().remove(name);
	}
	
	/**
	 * Displays all files & directories with their hierarchical structure (for file
	 *	display all file properties and for Directory all its properties)
	 */
	public void showFileSystem () {
		fs.printComponents(1);
	}
}