package lab5;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JpaProgram {
	public static void main(String[] args) {
//		create();
//		update();
//		delete();
//		findAll();
//		findByRole(true);
//		findByKeyWord("Hải");
		findOne("haipro1907", "Haipro19072");
//		int totalPages = 32 / 4; // Số lượng trang được tính dựa trên tổng số người dùng và kích thước mỗi trang : tính được =8
//		int pageSize = 4; // Số lượng người dùng trên mỗi trang
//		findPage(3, pageSize);//đang đứng ở trang 3 
	}

	public static User find(String ID) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PolyOe");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(User.class, ID);
	}

	public static String create(User user) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOe");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();// Bắt đầu Transaction
			em.persist(user);
			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("Thêm mới thành công");
			return "Thêm mới thành công";
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Thêm mới thất bại");
			return "Thêm mới thất bại";
		}
	}

	public static String update(User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOe");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();// Bắt đầu Transaction
			em.merge(user);
			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("Cập nhật thành công");
			return "Cập nhật thành công";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
			System.out.println("Cập Nhật thất bại");
			return "Cập nhật thất bại";
		}
	}

	public static String delete(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PolyOe");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			User userd = entityManager.find(User.class, user.getID());
			entityManager.remove(userd);
			entityManager.getTransaction().commit();
			System.out.println("Xóa thành công");
			return "Xóa thành công";
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Xóa thất bại");
			return "Xóa thất bại";
		}
	}

	public static List<User> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PolyOe");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			String sqlFindAll = "select o from User o";
			TypedQuery<User> query = entityManager.createQuery(sqlFindAll, User.class);
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println(user.getID());

			}
			return list;

		} catch (Exception e) {
			System.out.println("Lỗi findAll");
		}
		return null;

	}

	public static void findByRole(boolean role) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PolyOe");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			String sqlFindByRole = "select o from User o where o.Admin=:role";
			TypedQuery<User> query = entityManager.createQuery(sqlFindByRole, User.class);
			query.setParameter("role", role);
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println(user.getID() + " - Quyền :" + role);
			}
		} catch (Exception e) {
			System.out.println("Lỗi truy vấn findByRole =" + role);
		}
	}

	public static void findByKeyWord(String keyWord) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PolyOe");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			String sqlfindByKeyWord = "select o from User o where o.Fullname LIKE :fullName";
			TypedQuery<User> query = entityManager.createQuery(sqlfindByKeyWord, User.class);
			query.setParameter("fullName", "%" + keyWord + "%");
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println(user.getFullname());
			}
		} catch (Exception e) {
			System.out.println("Lỗi truy vấn findByKeyWord : " + keyWord);
		}
	}

	public static String findOne(String id, String pass) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PolyOe");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String sqlFindOne = "select o from User o where o.ID=:id AND o.password=:pass";
			TypedQuery<User> query = entityManager.createQuery(sqlFindOne, User.class);
			query.setParameter("id", id);
			query.setParameter("pass", pass);
			User user = query.getSingleResult();
			System.out.println(user.getFullname() + " - " + user.isAdmin());
			
			return "Đăng Nhập thành công";
		} catch (Exception e) {
			System.out.println("Lỗi truy vấn findOne()" + e.getMessage());
			return "Đăng Nhập thất bại ! Sai tài khoản hoặc mật khẩu";
		}
	}

	public static List<User> findPage(int page, int size) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PolyOe");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {

			String jpql = "SELECT o FROM User o";
			TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
			query.setFirstResult(page * size);
			query.setMaxResults(size);
			return query.getResultList();

		
		} catch (Exception e) {
			System.out.println("Lỗi truy vấn findPage()");
		}
		return null;
	}
}
