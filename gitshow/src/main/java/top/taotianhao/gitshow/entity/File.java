package top.taotianhao.gitshow.entity;

/**
 * @Author Tianhao Tao
 * @Date 2020/11/24 11:03
 * @Version 1.0
 */
public class File {
    private String id;
    private String name;
    private String parent;
    private String child;
    private boolean flag;
    private boolean path;

    public File(String id, String name, String parent, String child, boolean flag, boolean path) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.child = child;
        this.flag = flag;
        this.path = path;
    }

    public boolean isPath() {
        return path;
    }

    public void setPath(boolean path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
