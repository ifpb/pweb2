package br.com.ifpb.pweb2.securitydemo.util;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListUtils {

    public long totalElementos(List list){
        return list.size();
    }

    public double media(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public int soma(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public int maximo(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public int minimo(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).min().getAsInt();
    }
}
