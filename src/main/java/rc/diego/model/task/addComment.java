package rc.diego.model.task;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOComment;
import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.persistence.AbstractFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

/**
 * Created by entakitos on 20/02/16.
 */
public class addComment implements InterfaceTask {


    private VOComment comment;


    private InterfaceDAOFactory daoFactory;
    private boolean ok;


    public VOComment getVOComment() {
        return comment;
    }

    public void setVOComment(VOCd VOComment) {
        this.comment = comment;
    }

    public addComment(VOComment comment) {
        this.comment = comment;
    }

    @Override
    public void run() {
        System.out.println("AddComentClass");
        daoFactory = new AbstractFactoryMySQL();
        ok = daoFactory.getDAOComments().insertComment(comment);
    }

    public boolean isOk(){
        return ok;
    }
}
