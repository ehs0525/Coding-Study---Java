package java_0803;

public class dd {

	public static void main(String[] args) {

		System.out.println(solution("xababcdcdababcdcd"));
	}

	public static int solution(String s) {
		int answer = s.length();
		// StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder unit = new StringBuilder();
			StringBuilder condensed = new StringBuilder();
			String temp;

			unit.append(s.substring(0, i));
			int count = 1;

			for (int j = i; j < s.length(); j += i) {
				if(j+i>=s.length())
					temp = s.substring(j);
				else
					temp = s.substring(j, j+i);
				if (temp.equals(unit.toString())) {
					count++;
				} else {
					if (count >= 2)
						condensed.append(count).append(unit.toString());
					else
						condensed.append(unit.toString());
					unit = new StringBuilder();
					if (j + i >= s.length())
						unit.append(s.substring(j));
					else
						unit.append(s.substring(j, j + i));
					count = 1;
				}
			}
			
			if (count >= 2)
				condensed.append(count).append(unit.toString());
			else
				condensed.append(unit.toString());
			System.out.println(i + " " +condensed);
			answer = Integer.min(answer, condensed.length());
		}
		
		/*for(int i = 1; i <= s.length();i ++) {
			StringBuilder unit = new StringBuilder();
			
			
		}*/
		
		return answer;

	}

}
