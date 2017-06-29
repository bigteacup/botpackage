package botpackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Vector;


public final class FileTools {
 

	public FileTools() {
	}
 

	public static void checkFolder(String folderPath) {
		File file = new File(folderPath);
		if (!(file.isDirectory())) {
			file.mkdir();
	
		}
	}
 

	public static void deleteDirectory(File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
					
				}
			}
		}
		path.delete();
		
	}
 

	public static void move(String src, String dst) {
		File source = new File(src);
		File destination = new File(dst);
		// Try to use renameTo
		boolean result = source.renameTo(destination);
		if (!result) {
			// Copy
			copy(src, dst);
		} else {
		
		}
	}
 

	public static void copy(String src, String dst) {
	
		File source = new File(src);
		File destination = new File(dst);
		FileInputStream sourceFile = null;
		FileOutputStream destinationFile = null;
		try {
			destination.createNewFile();
			sourceFile = new FileInputStream(source);
			destinationFile = new java.io.FileOutputStream(destination);
			// Read by 0.5MB segment.
			byte buffer[] = new byte[512 * 1024];
			int nbRead;
			while ((nbRead = sourceFile.read(buffer)) != -1) {
				destinationFile.write(buffer, 0, nbRead);
			}
			sourceFile.close();
			destinationFile.close();
		} catch (Exception e) {
			
		}
	}
 

	public static void copyFolderToFolder(String currentFolder,
			String relatedPath, String sourceFolder, String destinationFolder
			) {
		// Current Directory.
		
		File current = new File(currentFolder);
		if (current.isDirectory()) {
			// List all files and folder in the current directory.
			File[] list = current.listFiles();
			if (list != null) {
				// Read the files list.
				for (int i = 0; i < list.length; i++) {
					// Create current source File
					File tf = new File(sourceFolder + relatedPath + "\\"
							+ list[i].getName());
					// Create current destination File
					File pf = new File(destinationFolder + relatedPath + "\\"
							+ list[i].getName());
					if (tf.isDirectory() && !pf.exists()) {
						// If the file is a directory and does not exit in the
						// destination Folder.
						
						// creer dossier
						pf.mkdir();
						copyFolderToFolder(tf.getAbsolutePath(), relatedPath
								+ "\\" + tf.getName(), sourceFolder,
								destinationFolder);
					} else if (tf.isDirectory() && pf.exists()) {
						// If the file is a directory and exits in the
						// destination Folder.
						copyFolderToFolder(tf.getAbsolutePath(), relatedPath
								+ "\\" + tf.getName(), sourceFolder,
								destinationFolder);
					} else if (tf.isFile()) {
						// If it is a file.
						
						copy(sourceFolder + relatedPath + "\\"
								+ list[i].getName(), destinationFolder
								+ relatedPath + "\\" + list[i].getName());
					} else {
						// Other cases.
						
					}
				}
			}
		}
	}
 

	public static void removeFiles(Vector<String> files,
			String projectDirectory) {
		Iterator<String> it = files.iterator();
		
		while (it.hasNext()) {
			removeFile(it.next(), projectDirectory);
		}
	}
 

// supprime fichier 
//file path.
 //root directory.
// logger.

	public static void removeFile(String file, String rootDirectory) {
		
		if (file.equalsIgnoreCase("") || file == null) {
		
		}
		File dir = new File(rootDirectory);
		if (!dir.isDirectory()) {
			
		} else {
			String filename;
			if (rootDirectory.charAt(rootDirectory.length() - 1) == '/') {
				filename = rootDirectory + file;
			} else {
				filename = rootDirectory + "/" + file;
			}
			File f = new File(filename);
			if (f.exists()) {
				f.delete();
				
			} else {
				
			}
		}
	}
}