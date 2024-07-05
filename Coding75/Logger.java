import java.util.HashMap;

public class Logger {

	// initailization of requests hash map
	private HashMap<String, Integer> requests;
	int limit;

	public Logger(int timeLimit) {
		requests = new HashMap<String, Integer> ();
		limit = timeLimit;
	}

	// function to accept and deny message requests

	public boolean messageRequestDecision(int timestamp, String request) {

		if (!this.requests.containsKey(request)) {
			this.requests.put(request, timestamp);
			return true;
		}

		if (timestamp - this.requests.get(request) >= limit) {
			this.requests.put(request, timestamp);
			return true;
		} else {
			return false;
		}
	}
}
