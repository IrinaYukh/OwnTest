package home.addressbook.data;

public class GroupData
{
    private String header;
    private String comment;
    private String name;

    public GroupData setHeader(String header)
    {
        this.header = header;
        return this;
    }

    public GroupData setComment(String comment)
    {
        this.comment = comment;
        return this;
    }

    public GroupData setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getHeader() {
        return header;
    }

    public String getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }
}
