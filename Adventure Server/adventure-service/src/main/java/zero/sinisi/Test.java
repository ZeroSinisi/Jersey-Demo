package zero.sinisi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {
		DemoFirst();
		DemoSecond();
	}

	public static void readDB() {
		MySqlAccess dao = new MySqlAccess();
		try {
			dao.readDataBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void DemoFirst() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Player player = new Player();
		player.setName("Dave");
		session.save(player);
		session.getTransaction().commit();
		session.close();
	}

	public static void DemoSecond() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Player> players = session.createQuery("from Player").list();
		session.close();
		for (Player st : players) {
			System.out.println(st.getName());
		}
	}
}
