package zero.sinisi;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class Main {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080").path("webapi");
		Response r = target.path("player").request().get();
		System.out.println(r.getStatus());
		List<Player> players = r.readEntity(new GenericType<List<Player>>() {});
		System.out.println("Current Players in database");
		for (Player player : players) {
			System.out.println(player);
		}
		System.out.println('\n' + "Adding New Player");
		Player newPlayer = new Player();
		newPlayer.setName(args[0]);
		Entity<Player> tim2send = Entity.json(newPlayer);
		r = target.path("player").path("add").request().post(tim2send);
		// System.out.println(r.getStatus());
		r = target.path("player").request().get();
		// System.out.println(r.getStatus());
		System.out.println('\n' + "Current Players in database");
		players = r.readEntity(new GenericType<List<Player>>() {});
		for (Player player : players) {
			System.out.println(player);
		}
		System.out.println('\n' + "Changing first player's name");
		players.get(0).setName("New Guy McNewName");
		r = target.path("player").path("update").request().post(Entity.json(players.get(0)));
		// System.out.println('\n' + r.getStatus());
		players = target.path("player").request().get().readEntity(new GenericType<List<Player>>() {});
		System.out.println('\n' + "Current Players in database");
		for (Player player : players) {
			System.out.println(player);
		}
	}
}
