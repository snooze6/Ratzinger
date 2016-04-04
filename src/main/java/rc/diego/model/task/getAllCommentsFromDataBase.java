package rc.diego.model.task;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOComment;
import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.persistence.AbstractFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

import java.util.ArrayList;

/**
 * Created by entakitos on 17/03/16.
 */
public class getAllCommentsFromDataBase implements InterfaceTask{

    private InterfaceDAOFactory daoFactory;

    private VOCd cd;
    private ArrayList<VOComment> commentsUnrrolled = new ArrayList<VOComment>();
    public getAllCommentsFromDataBase(VOCd cd) {
        this.cd = cd;
    }

    public ArrayList<VOComment> comments;

    public ArrayList<VOComment> getComments() {
        return comments;
    }

    public void getCommentsUnrrolled(ArrayList<VOComment> comments,int deep){
        int i=0;
        for(i=0;i<comments.size();i++){
            comments.get(i).setDeep(deep);
            commentsUnrrolled.add(comments.get(i));
            //System.out.println("El tamaño del hijo es " + comments.get(i).getChildCommentsArray().size());
            getCommentsUnrrolled(comments.get(i).getChildCommentsArray(),deep+1);
        }
    }

    public ArrayList<VOComment> getCommentsUnrrolled() {
        getCommentsUnrrolled(comments,0);
        return commentsUnrrolled;
    }

    public void setComments(ArrayList<VOComment> comments) {
        this.comments = comments;
    }



    @Override
    public void run() {
        daoFactory = new AbstractFactoryMySQL();
        try {
            comments = daoFactory.getDAOComments().getCommentsByProduct(cd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
