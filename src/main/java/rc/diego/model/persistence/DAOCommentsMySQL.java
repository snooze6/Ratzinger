package rc.diego.model.persistence;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOComment;
import rc.diego.model.persistence.Connector.MySQLContract;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by entakitos on 17/03/16.
 */
public class DAOCommentsMySQL extends AbstractDAOMySQL implements InterfaceDAOComments {

    private final String getProductsSQL = "SELECT * FROM "+ MySQLContract.Comments.TABLE_NAME + " WHERE " +MySQLContract.Comments.idCommentParent+ " IS NULL" + ";";

    private PreparedStatement statementGetChild = null;

    private String getChild = "SELECT * FROM " + MySQLContract.Comments.TABLE_NAME+ " WHERE " +MySQLContract.Comments.idCommentParent + " = ? ; ";


    private PreparedStatement insertComment = null;
    private String insertCommentSQL = "INSERT INTO `"+ MySQLContract.Comments.TABLE_NAME+"` (`"+
            MySQLContract.Comments.idCommentParent+"`,`"+
            MySQLContract.Comments.tittle+"`,`"+
            MySQLContract.Comments.content+"`,`"+
            MySQLContract.Comments.idProduct+"`,`"+
            MySQLContract.Comments.DNI+
            "`)  VALUES(?,?,?,?,?);";


    @Override
    public boolean insertComment(VOComment comment)  {

        try {


            insertComment = getConnection().prepareStatement(insertCommentSQL);
            if (comment.getIdCommentParent() != -1) {
                insertComment.setInt(1, comment.getIdCommentParent());
            } else {
                insertComment.setNull(1, java.sql.Types.INTEGER);

            }
            insertComment.setString(2, comment.getTitle());
            insertComment.setString(3, comment.getContent());
            insertComment.setInt(4, comment.getIdProduct());
            insertComment.setString(5, comment.getDNI());
            insertComment.executeUpdate();

        }catch (SQLException e) {
                e.printStackTrace();
                return false;
            }finally {
            if(insertComment != null)
                try {
                    insertComment.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


    return true;
    }

    @Override
    public ArrayList<VOComment> getCommentsByProduct(VOCd cd) throws Exception {
        ArrayList<VOComment> comments = new ArrayList<VOComment>();
        System.out.println("Executing");
        try {
            ResultSet results=getConnection().createStatement().executeQuery(getProductsSQL);

            while(results.next()){
                VOComment comment=new VOComment();
                comment.setIdComment(results.getInt(MySQLContract.Comments.idComment));
                comment.setIdProduct(results.getInt(MySQLContract.Comments.idProduct));
                comment.setContent(results.getString(MySQLContract.Comments.content));
                comment.setDNI(results.getString(MySQLContract.Comments.DNI));
                comment.setTitle(results.getString(MySQLContract.Comments.tittle));
                comments.add(comment);
                System.out.println("El padre con id "+comment.getIdComment());
                getChild(comment);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
/*        try {
            comments.get(0).setIdComment(100);
            insertComment(comments.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return comments;
    }

    private void getChild(VOComment comment) throws SQLException {
//        ResultSet resultsChild = getConnection().createStatement().executeQuery(getChild);

        getConnection().setAutoCommit(false);
        statementGetChild = getConnection().prepareStatement(getChild);
        statementGetChild.setInt(1, comment.getIdComment());

        ResultSet resultsChild= statementGetChild.executeQuery();
        while(resultsChild.next()){
            VOComment child = new VOComment();
            child.setIdComment(resultsChild.getInt(MySQLContract.Comments.idComment));
            child.setIdComment(resultsChild.getInt(MySQLContract.Comments.idComment));
            child.setIdProduct(resultsChild.getInt(MySQLContract.Comments.idProduct));
            child.setContent(resultsChild.getString(MySQLContract.Comments.content));
            child.setDNI(resultsChild.getString(MySQLContract.Comments.DNI));
            child.setTitle(resultsChild.getString(MySQLContract.Comments.tittle));
            child.setIdCommentParent(resultsChild.getInt(MySQLContract.Comments.idCommentParent));
            child.getChildCommentsArray().add(child);
            System.out.println("Hijo de " +comment.getIdComment() + " introducido con ID "+ child.getIdComment() );
            getChild(child);
        }
        getConnection().setAutoCommit(true);
    }




    public DAOCommentsMySQL() {
        super();
    }
}
