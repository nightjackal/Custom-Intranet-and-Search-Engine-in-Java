import java.util.ArrayList;
import java.util.List;

class SearchEngine {
    public void listOutputer(String searchQueryListOutputer) {
        List<String> results = new ArrayList<>();
        ListMethods listMethods = new ListMethods();
        results = listMethods.searchResults(searchQueryListOutputer);
        for (int i = 0; i < results.size(); i++) {
            System.out.println("\n" + ShellCommands.colorCodesData[5] +  results.get(i) + "\n\033[0m");
        }
        
    }

    protected double matches[] = {};
    protected String fileNames[] = {"mainFrameDesign.txt", "hi.txt", "yep.txt"};
}

class ListMethods extends SearchEngine{
    public List<String> listOfResults = new ArrayList<>();
    public  List<String> searchResults(String searchResultsString) {
        boolean topResults[] = searchEngine(searchResultsString);
        for (int i = 0; i < topResults.length; i++) {
            if (topResults[i] == true) {
                listOfResults.add(fileNames[i]);
            }
        }
        return listOfResults;
    }

    private boolean[] searchEngine (String searchEngineString) {
        int matchingLetters[] = {0, 0, 0};
        double matchPercentages[] = {0.0, 0.0, 0.0};
        boolean topTenResults[] = {false, false, false};
        String character_j = "";
        for (int i = 0; i < fileNames.length; i++) {
            for (int j = 0; j < fileNames[i].length(); j++) {
                character_j = fileNames[i].substring(j, j + 1); // What is this doing?
                for (int k = 0; k < searchEngineString.length(); k++) {
                    if (searchEngineString.substring(k, k + 1).equals(character_j)) {
                        matchingLetters[i]++;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            matchPercentages[i] = ((double) matchingLetters[i] / searchEngineString.length());
            topTenResults[i] = true;
        }
        return topTenResults;
    };
}
