package model;

import java.util.LinkedList;

public class Folders {
	private LinkedList<Document> folder;
	
	public Folders(LinkedList<Document> forlder) {
		this.folder = new LinkedList<Document>();
		for(int index=0;index<folder.size();index++) {
			this.folder.add(new Document(folder.get(index)));
		}
	}
	
	public Folders(Folders other) {
		this(other.folder);
	}
	
	public LinkedList<Document> getFold(){
		return this.folder;
	}
	
	public Document getDoc(int index) {
		return this.folder.get(index);
	}
	
	public int getIndex(Document Doc) {
		for(int index=0;index<this.folder.size();index++) {
			if(Doc.equals(this.folder.get(index))) {
				return index;
			}
		}
		return this.folder.size();
	}
	
	/*
	public afficherDoc(Document doc) {
		doc.afficher();
	}
	*/
}
