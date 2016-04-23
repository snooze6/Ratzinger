package rc.diego.model.task;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOComment;
import rc.diego.model.persistence.DataManager;

/**
 * Created by entakitos on 20/02/16.
 */
public class addComment implements InterfaceTask {


    private VOComment comment;

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

        ok = DataManager.getDAOComments().insertComment(comment);

    }

    public boolean isOk(){
        return ok;
    }
}
