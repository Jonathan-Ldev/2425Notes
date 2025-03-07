public class Capybara extends Animal implements Walking{

    public Capybara(){
        super("Coconut Dog","Also known as \"Nature's Chair\" or the \"Hydrochoerus hydrochaeris\", the capybara is EXTREMELY social. It's so social that it will try to befriend the local predators");
    }
    @Override
    public String makeNoise() {
        return "*Whistles*";
    }
    @Override
    public String walk(){
        return "Coconut Dog do be walking";
    }
    
}
