package lectures;


import beans.Car;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    long count = MockData.getPeople()
        .stream()
        .filter(person -> person.getGender().equalsIgnoreCase("male"))
        .count();
    System.out.println(count);
  }

  @Test
  public void min() throws Exception {
    double min = MockData.getCars()
        .stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .min()
        .orElse(0);
    System.out.println(min);
  }

  @Test
  public void max() throws Exception {
    double max = MockData.getCars()
        .stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .max()
        .orElse(0);
    System.out.println(max);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
//    ImmutableList<Car> cars = ImmutableList.of();

    double average = cars.stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);
    System.out.println(average);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);
  }

  @Test
  public void statistics() throws Exception {
    DoubleSummaryStatistics doubleSummaryStatistics = MockData.getCars().stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(doubleSummaryStatistics.getMin());
    System.out.println(doubleSummaryStatistics.getMax());
    System.out.println(doubleSummaryStatistics.getAverage());
    System.out.println(doubleSummaryStatistics.getSum());
    System.out.println(doubleSummaryStatistics.getCount());
  }

}