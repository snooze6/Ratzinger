package rc.diego.model.persistence;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOComment;

import java.util.ArrayList;

/**
 * Created by denis on 3/04/16.
 */
public interface InterfaceDAOComments {
     ArrayList<VOComment> getCommentsByProduct(VOCd cd) throws Exception;
     boolean insertComment(VOComment comment);
}
