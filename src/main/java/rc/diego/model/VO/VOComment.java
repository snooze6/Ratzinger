package rc.diego.model.VO;

import java.util.ArrayList;

/**
 * Created by denis on 3/04/16.
 */
public class VOComment {

    private ArrayList<VOComment> childCommentsArray;
    private String title;
    private int idCommentParent;
    private int idComment;
    private int idProduct;
    private String DNI;
    private String content;
    private String date;



    public VOComment(){
        this.childCommentsArray = new ArrayList<VOComment>();
        idCommentParent=-1;
    }

    public VOComment( String title, int idCommentParent, int idComment, int idProduct, String DNI, String content) {
        this.childCommentsArray = new ArrayList<VOComment>();
        this.title = title;
        this.idCommentParent = idCommentParent;
        this.idComment = idComment;
        this.idProduct = idProduct;
        this.DNI = DNI;
        this.content = content;
    }


    public ArrayList<VOComment> getChildCommentsArray() {
        return childCommentsArray;
    }

    public void setChildCommentsArray(ArrayList<VOComment> childCommentsArray) {
        this.childCommentsArray = childCommentsArray;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdCommentParent() {
        return idCommentParent;
    }

    public void setIdCommentParent(int idCommentParent) {
        this.idCommentParent = idCommentParent;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void add(VOComment childComment){
        childCommentsArray.add(childComment);
    }



}

