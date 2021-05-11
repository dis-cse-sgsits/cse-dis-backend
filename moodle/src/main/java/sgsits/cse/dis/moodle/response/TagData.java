package sgsits.cse.dis.moodle.response;

public class TagData {
	private Long tagId;
	private String tagName;
	private String tagRawName;
	
	
	public TagData() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TagData(Long tagId, String tagName, String tagRawName) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagRawName = tagRawName;
	}


	public Long getTagId() {
		return tagId;
	}


	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}


	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


	public String getTagRawName() {
		return tagRawName;
	}


	public void setTagRawName(String tagRawName) {
		this.tagRawName = tagRawName;
	}
	
	@Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if(obj instanceof TagData)
        {
        	TagData temp = (TagData) obj;
            if(this.tagId.equals(temp.tagId) && this.tagName.equals(temp.tagName) && this.tagRawName.equals(temp.tagRawName))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        
        return (this.tagId.hashCode() + this.tagName.hashCode() + this.tagRawName.hashCode());
    }

}
