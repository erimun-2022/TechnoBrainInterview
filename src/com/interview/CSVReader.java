package com.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 
 * @author ERIC
 *
 */
public class CSVReader {

	/**
	 * Function reads a log file of type csv, returns top ips
	 */
	public static List<String> returnCommonIpsInALog(int top, String logLocation) {

		List<String> commonIps = new LinkedList<>();

		List<String> ipList = new LinkedList<>();

		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(logLocation))) {
			while ((line = br.readLine()) != null) {
				String[] ips = line.split(",");
				ipList.add(ips[2]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Map frequency by grouping by
		Map<String, Long> map = ipList.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));

		// Collect top ips
		List<Map.Entry<String, Long>> result = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(top).collect(Collectors.toList());

		// Add common IPS into a list
		for (Entry<String, Long> v : result) {
			commonIps.add(v.getKey());
		}

		return commonIps;

	}

	public static void main(String[] args) {

		{

			List<String> commonIps = returnCommonIpsInALog(10, "test.csv");

			System.out.println("A List of common IPs ::: \n" + commonIps);

		}
	}

}
