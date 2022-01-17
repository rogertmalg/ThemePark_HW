import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import java.util.ArrayList;
import java.util.HashMap;


public class ThemePark {
    private ArrayList<IReviewed> stallsAndAttractions;

    public ThemePark() {
        this.stallsAndAttractions = new ArrayList<>();

    }

    public void addIReviewed(IReviewed newItem){
        stallsAndAttractions.add(newItem);
    }

    public ArrayList<IReviewed> getAllReviewed(){
        return stallsAndAttractions;
    }

    public void visit(Visitor _visitor, Attraction _attraction){
        _attraction.upVisitCount();
        _visitor.addAttraction(_attraction);
    }

    public HashMap<String, Integer> allReviews(){
        HashMap<String, Integer> reviews = new HashMap<>();
        for (IReviewed item : stallsAndAttractions){
            String name = item.getName();
            int value = item.getRating();
            reviews.put(name, value);
        }
        return reviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor _visitor){
        ArrayList<IReviewed> allowedList = new ArrayList<>();
        for (IReviewed item : stallsAndAttractions){
            if (item.getClass().getName() == "attractions.RollerCoaster" ||
                    item.getClass().getName() == "attractions.Playground" ||
                    item.getClass().getName() == "stalls.TobaccoStall" ){
                if (((ISecurity) item).isAllowedTo(_visitor) == true){
                    allowedList.add(item);
                }
            } else {
                allowedList.add(item);
            }
        }
        return allowedList;
    }

/* annother way of solving the above.
    public ArrayList<IReviewed> getAllAllowed(Visitor visitor) {
        ArrayList<IReviewed> allowedAttractions = new ArrayList<IReviewed>();
        for (Attraction attraction : attractions){
            if (attraction instanceof ISecurity){
                if (((ISecurity) attraction).isAllowed(visitor)){
                    allowedAttractions.add(attraction);
                }
            } else {
                allowedAttractions.add(attraction);
            }
        }
        return allowedAttractions;
    }
*/
}
