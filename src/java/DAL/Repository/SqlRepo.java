/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Repository;

import DAL.DataSource.DataSourceSingleton;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.Article;
import model.AuthenticatedUser;
import model.AuthenticatedUserCart;
import model.AuthenticatedUserCartItem;
import model.AuthenticatedUserSession;
import model.NotAuthenticatedUserSession;

/**
 *
 * @author RudolfGumzej
 */
public class SqlRepo implements IRepo{
    
      private static final String INSERT_USER = "{ CALL insertUser (?,?,?,?,?,?,?,?) }";
      private static final String GET_USER = "{ CALL getUser (?) }";
      private static final String GET_USER_BY_USERNAME = "{ CALL getUserByUsername (?) }";
      private static final String DELETE_USER = "{ CALL deleteUser (?) }";
      private static final String LOGIN_USER = "{ CALL logInUser (?,?) }";
      private static final String GET_ALL_USERS = "{ CALL getAllUsers }";
      private static final String UPDATE_USER = "{ CALL updateUser (?,?,?,?,?,?,?,?) }";
       
       
      private static final String INSERT_AUTHENTICATED_SESSION = "{ CALL insertAuthenticatedSession (?,?,?,?) }";
      private static final String GET_AUTHENTICATED_SESSION = "{ CALL getAuthenticatedUserSession (?) }";
      private static final String GET_ALL_AUTHENTICATED_SESSIONS = "{ CALL getAllAuthenticatedUserSessions }";
      
      private static final String INSERT_NOT_AUTHENTICATED_SESSION = "{ CALL insertNotAuthenticatedSession (?,?,?) }";
      private static final String GET_NOTAUTHENTICATED_SESSION = "{ CALL getNotAuthenticatedUserSession (?) }";
      private static final String GET_ALL_NOTAUTHENTICATED_SESSIONS = "{ CALL getAllNotAuthenticatedUserSessions }";
      
      private static final String GET_ARTICLE = "{ CALL getArticle (?) }";
      private static final String GET_ARTICLE_BY_ID = "{ CALL getAricleById (?) }";
      private static final String GET_ALL_ARTICLES = "{ CALL getAllArticles }";
      
      
      
      private static final String INSERT_AUTHENTICATED_USER_CART_ITEM = "{ CALL insertauthenticatedUserCartItem (?,?,?,?,?) }";
      private static final String UPDATE_AUTHENTICATED_USER_CART_ITEM = "{ CALL updateAuthenticatedUserCartItem (?,?,?,?,?) }";
      private static final String DELETE_AUTHENTICATED_USER_CART_ITEM = "{ CALL deleteAuthenticatedCartItem (?) }";
      private static final String VIEW_CART_ITEMS_FOR_CART = "{ CALL viewCartItemsForCart (?) }";
      private static final String VIEW_ALL_AUTHENTICATED_USER_CART_ITEMS = "{ CALL viewAllAuthenticatedUserCartItems }";
      private static final String VIEW_AUTHENTICATED_USER_CART_ITEM = "{ CALL viewAuthenticatedCartItem (?) }";
      
      private static final String INSERT_AUTHENTICATED_USER_CART = "{ CALL insertAuthenticatedUserCart (?,?,?,?,?,?,?) }";
      private static final String UPDATE_AUTHENTICATED_USER_CART = "{ CALL updateAuthenticatedUserCart (?,?,?,?,?,?,?) }";
      private static final String DELETE_AUTHENTICATED_USER_CART = "{ CALL deleteAuthenticatedUserCart (?) }";
      private static final String VIEW_AUTHENTICATED_USER_CART = "{ CALL viewAuthenticatedUserCart (?) }";
      private static final String VIEW_ALL_AUTHENTICATED_USER_CART = "{ CALL viewAllAuthenticatedUserCart }";
      private static final String GET_CART_FOR_AUTHENTICATED_USER = "{ CALL getCartForAuthenticatedUser (?) }";
     


    @Override
    public int insertUser(AuthenticatedUser user) {
            DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(INSERT_USER)) {
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getAdress());
            stmt.setString(7, user.getUsername());
            stmt.setString(8, user.getPassword());
           
            
            
            stmt.executeUpdate();
            return stmt.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public AuthenticatedUser getUser(int id) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_USER)){
                stmt.setInt(1, id);
            try(ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new AuthenticatedUser(
                                 resultSet.getInt("idAuthenticatedUser"), 
                                    resultSet.getString("name"), 
                                    resultSet.getString("surname"),
                                    resultSet.getString("email"),
                                    resultSet.getString("phone"),
                                    resultSet.getString("adress"),
                                    resultSet.getString("username"),
                                    resultSet.getString("password"));
                                    
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AuthenticatedUser logInUser(String username, String password) {
          DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(LOGIN_USER)){
                stmt.setString(1, username);
                stmt.setString(2, password);
            try(ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new AuthenticatedUser(
                                 resultSet.getInt("idAuthenticatedUser"), 
                                    resultSet.getString("name"), 
                                    resultSet.getString("surname"),
                                    resultSet.getString("email"),
                                    resultSet.getString("phone"),
                                    resultSet.getString("adress"),
                                    resultSet.getString("username"),
                                    resultSet.getString("password"));
                                    
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AuthenticatedUser> getAllUsers() {
            List<AuthenticatedUser> users = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ALL_USERS);
                ResultSet resultSet = stmt.executeQuery()){
                    while (resultSet.next()) {
                        users.add(
                                new AuthenticatedUser(
                                     resultSet.getInt("idAuthenticatedUser"), 
                                    resultSet.getString("name"), 
                                    resultSet.getString("surname"),
                                    resultSet.getString("email"),
                                    resultSet.getString("phone"),
                                    resultSet.getString("adress"),
                                    resultSet.getString("username"),
                                    resultSet.getString("password")));
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(AuthenticatedUser user, int idUser) {
           DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_USER)) {
            stmt.setInt(1, idUser);
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getAdress());
            stmt.setString(7, user.getUsername());
            stmt.setString(8, user.getPassword());
            
            
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public void deleteUser(int idUser) {
           DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_USER)) {
            stmt.setInt(1, idUser);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public void insertAuthenticatedSession(AuthenticatedUserSession session) {
               DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(INSERT_AUTHENTICATED_SESSION)) {
            
            stmt.setInt(1, session.getAuthenticatedUserId());
             stmt.setTimestamp(2,Timestamp.valueOf(session.getSessionDate()));
            stmt.setString(3, session.getIp_adress());
            stmt.setString(4, session.getUsername());
          
           
            
            
            stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    @Override
    public List<AuthenticatedUserSession> getAuthenticatedSession(int userId) {
       List<AuthenticatedUserSession> sessions = new ArrayList<>();
         DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_AUTHENTICATED_SESSION)){
                stmt.setInt(1, userId);
            try(ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    sessions.add(
                    new AuthenticatedUserSession(
                               resultSet.getInt("idAuthenticatedUserSession"), 
                                    resultSet.getInt("authenticatedUserId"), 
                                    resultSet.getTimestamp("sessionDate").toLocalDateTime(),
                                    resultSet.getString("ip_adress"),
                                    resultSet.getString("username"))
                    );
                    
                }
                return sessions;
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AuthenticatedUserSession> getAllAuthenticatedSessions() {
                List<AuthenticatedUserSession> authenticatedSessions = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ALL_AUTHENTICATED_SESSIONS);
                ResultSet resultSet = stmt.executeQuery()){
                    while (resultSet.next()) {
                        authenticatedSessions.add(
                                new AuthenticatedUserSession(
                                        
                                   resultSet.getInt("idAuthenticatedUserSession"), 
                                    resultSet.getInt("authenticatedUserId"), 
                                    resultSet.getTimestamp("sessionDate").toLocalDateTime(),
                                    resultSet.getString("ip_adress"),
                                    resultSet.getString("username"))
                        );
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticatedSessions;
    }

    @Override
    public void insertNotAuthenticatedSession(NotAuthenticatedUserSession session) {
              DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(INSERT_AUTHENTICATED_SESSION)) {
            
            stmt.setInt(1, session.getNotAuthenticatedUserId());
             stmt.setTimestamp(2,Timestamp.valueOf(session.getSessionDate()));
            stmt.setString(3, session.getIp_adress());
          
           
            
            
            stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    @Override
    public NotAuthenticatedUserSession getNotAuthenticatedSession(int userId) {
          DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_AUTHENTICATED_SESSION)){
                stmt.setInt(1, userId);
            try(ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new NotAuthenticatedUserSession(
                                 resultSet.getInt("idNotAuthenticatedUserSession"), 
                                    resultSet.getInt("notAuthenticatedUserId"), 
                                    resultSet.getTimestamp("sessionDate").toLocalDateTime(),
                                    resultSet.getString("ip_adress"));
                                 
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NotAuthenticatedUserSession> getAllNotAuthenticatedSessions() {
                  List<NotAuthenticatedUserSession> notAuthenticatedSessions = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ALL_AUTHENTICATED_SESSIONS);
                ResultSet resultSet = stmt.executeQuery()){
                    while (resultSet.next()) {
                        notAuthenticatedSessions.add(
                                new NotAuthenticatedUserSession(
                                        
                                   resultSet.getInt("idNotAuthenticatedUserSession"), 
                                    resultSet.getInt("notAuthenticatedUserId"), 
                                    resultSet.getTimestamp("sessionDate").toLocalDateTime(),
                                    resultSet.getString("ip_adress")));
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notAuthenticatedSessions;
    }

    @Override
    public Article getArticle(String name) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ARTICLE)){
                stmt.setString(1, name);
            try(ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Article(
                                 resultSet.getInt("idArticle"), 
                                    resultSet.getString("name"), 
                                    resultSet.getInt("categoryId"),
                                    resultSet.getDouble("price"),
                                    resultSet.getString("description"),
                                    resultSet.getString("picturePath"));
                                                                 
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Article> getAllArticles() {
            List<Article> articles = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ALL_ARTICLES);
                ResultSet resultSet = stmt.executeQuery()){
                    while (resultSet.next()) {
                        articles.add(
                                new Article(
                                  resultSet.getInt("idArticle"), 
                                    resultSet.getString("name"), 
                                    resultSet.getInt("categoryId"),
                                    resultSet.getDouble("price"),
                                    resultSet.getString("description"),
                                    resultSet.getString("picturePath")));
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public int insertauthenticatedUserCartItem(AuthenticatedUserCartItem item) {
        
             DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(INSERT_AUTHENTICATED_USER_CART_ITEM)) {
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.setInt(2, item.getAuthenticatedUserCartId());
            stmt.setInt(3, item.getArticleId());
            stmt.setInt(4, item.getAmount());
            stmt.setDouble(5, item.getPrice());
           
                 
            
            stmt.executeUpdate();
            return stmt.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateAuthenticatedUserCartItem(AuthenticatedUserCartItem item, int idAuthenticatedUserCartItem) {
           DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_AUTHENTICATED_USER_CART_ITEM)) {
            stmt.setInt(1, idAuthenticatedUserCartItem);
           stmt.setInt(2, item.getAuthenticatedUserCartId());
            stmt.setInt(3, item.getArticleId());
            stmt.setInt(4, item.getAmount());
            stmt.setDouble(5, item.getPrice());
            
            
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public void deleteAuthenticatedCartItem(int idAuthenticatedUserCartItem) {
             DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_AUTHENTICATED_USER_CART_ITEM)) {
            stmt.setInt(1, idAuthenticatedUserCartItem);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public List<AuthenticatedUserCartItem> viewCartItemsForCart(int authenticatedUserCartId) {
        
         List<AuthenticatedUserCartItem> items = new ArrayList<>();
         DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(VIEW_CART_ITEMS_FOR_CART)){
                stmt.setInt(1, authenticatedUserCartId);
            try(ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    items.add(
                    new AuthenticatedUserCartItem(
                                resultSet.getInt("idAuthenticatedCartItem"), 
                                resultSet.getInt("authenticatedUserCartId"), 
                                resultSet.getInt("articleID"), 
                                resultSet.getInt("amount"), 
                                resultSet.getDouble("price") 
                                
                               ));
                    
                }
                return items;
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AuthenticatedUserCartItem> viewAllAuthenticatedUserCartItems() {
              List<AuthenticatedUserCartItem> items = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(VIEW_ALL_AUTHENTICATED_USER_CART_ITEMS);
                ResultSet resultSet = stmt.executeQuery()){
                    while (resultSet.next()) {
                        items.add(
                                new AuthenticatedUserCartItem(
                                 resultSet.getInt("idAuthenticatedCartItem"), 
                                resultSet.getInt("authenticatedUserCartId"), 
                                resultSet.getInt("articleID"), 
                                resultSet.getInt("amount"), 
                                resultSet.getDouble("price")));
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public int insertAuthenticatedUserCart(AuthenticatedUserCart cart) {
                DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(INSERT_AUTHENTICATED_USER_CART)) {
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.setInt(2, cart.getAuthanticatedUserId());
            stmt.setTimestamp(3, Timestamp.valueOf(cart.getShoppingDate()));
            stmt.setDouble(4, cart.getTotalPrice());
            stmt.setInt(5, cart.getAuthanticatedUserSessionId());
            stmt.setString(6, cart.getPaymentOption());
              stmt.setString(7, cart.getPayed());
           
                 
            
            stmt.executeUpdate();
            return stmt.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateAuthenticatedUserCart(AuthenticatedUserCart cart, int idAuthenticatedUserCart) {
                DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_AUTHENTICATED_USER_CART)) {
            stmt.setInt(1, idAuthenticatedUserCart);
           stmt.setInt(2, cart.getAuthanticatedUserId());
            stmt.setTimestamp(3, Timestamp.valueOf(cart.getShoppingDate()));
            stmt.setDouble(4, cart.getTotalPrice());
            stmt.setInt(5, cart.getAuthanticatedUserSessionId());
            stmt.setString(6, cart.getPaymentOption());
             stmt.setString(7, cart.getPayed());
            
            
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }        
        
    }

    @Override
    public void deleteAuthenticatedUserCart(int idAuthenticatedUserCart) {
              DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_AUTHENTICATED_USER_CART)) {
            stmt.setInt(1, idAuthenticatedUserCart);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public AuthenticatedUserCart viewAuthenticatedUserCart(int idAuthenticatedUserCart) {
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(VIEW_AUTHENTICATED_USER_CART)){
                stmt.setInt(1, idAuthenticatedUserCart);
            try(ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new AuthenticatedUserCart(
                                 resultSet.getInt("idCart"), 
                                    resultSet.getInt("authenticatedUserId"), 
                                    resultSet.getTimestamp("shoppingDate").toLocalDateTime(),
                                    resultSet.getDouble("totalPrice"),
                                    resultSet.getInt("authenticatedUserSessionId"),
                                    resultSet.getString("paymentOption"),
                                    resultSet.getString("payed"));
                                    
                                    
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AuthenticatedUserCart> viewAllAuthenticatedUserCart() {
        
        List<AuthenticatedUserCart> carts = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(VIEW_ALL_AUTHENTICATED_USER_CART);
                ResultSet resultSet = stmt.executeQuery()){
                    while (resultSet.next()) {
                        carts.add(
                                new AuthenticatedUserCart(
                                        
                                    resultSet.getInt("idCart"), 
                                    resultSet.getInt("authenticatedUserId"), 
                                    resultSet.getTimestamp("shoppingDate").toLocalDateTime(),
                                    resultSet.getDouble("totalPrice"),
                                    resultSet.getInt("authenticatedUserSessionId"),
                                    resultSet.getString("paymentOption"),
                                resultSet.getString("payed")));
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carts;
    }

    @Override
    public Article getArticleById(int id) {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ARTICLE_BY_ID)){
                stmt.setInt(1, id);
            try(ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Article(
                                 resultSet.getInt("idArticle"), 
                                    resultSet.getString("name"), 
                                    resultSet.getInt("categoryId"),
                                    resultSet.getDouble("price"),
                                    resultSet.getString("description"),
                                    resultSet.getString("picturePath"));
                                                                 
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AuthenticatedUserCartItem viewAuthenticatedCartItem(int id) {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(VIEW_AUTHENTICATED_USER_CART_ITEM)){
                stmt.setInt(1, id);
            try(ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new AuthenticatedUserCartItem(
                                resultSet.getInt("idAuthenticatedCartItem"), 
                                resultSet.getInt("authenticatedUserCartId"), 
                                resultSet.getInt("articleID"), 
                                resultSet.getInt("amount"), 
                                resultSet.getDouble("price"));
                                    
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AuthenticatedUserCart> getCartForAuthenticatedUser(int userID) {
            
        List<AuthenticatedUserCart> carts = new ArrayList<>();
         DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_CART_FOR_AUTHENTICATED_USER)){
                stmt.setInt(1, userID);
            try(ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    carts.add(
                    
                              new AuthenticatedUserCart(
                                        
                                    resultSet.getInt("idCart"), 
                                    resultSet.getInt("authenticatedUserId"), 
                                    resultSet.getTimestamp("shoppingDate").toLocalDateTime(),
                                    resultSet.getDouble("totalPrice"),
                                    resultSet.getInt("authenticatedUserSessionId"),
                                    resultSet.getString("paymentOption"),
                                resultSet.getString("payed")));
                    
                    
                }
                return carts;
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AuthenticatedUser getUserByUsername(String username) {
           DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_USER_BY_USERNAME)){
                stmt.setString(1, username);
            try(ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new AuthenticatedUser(
                                 resultSet.getInt("idAuthenticatedUser"), 
                                    resultSet.getString("name"), 
                                    resultSet.getString("surname"),
                                    resultSet.getString("email"),
                                    resultSet.getString("phone"),
                                    resultSet.getString("adress"),
                                    resultSet.getString("username"),
                                    resultSet.getString("password"));
                                    
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
