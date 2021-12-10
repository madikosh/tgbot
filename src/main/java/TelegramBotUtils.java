public interface TelegramBotUtils {
    String BOT_USERNAME="madi_testBot";
    String BOT_TOKEN="5002736179:AAETgKuAxkzkGKA2RZRgsZ_sheZ8i7hiHkY";

    default boolean isStart(String text){
        return  text.equals("/start");
    }
    default boolean areMyCards(String text){
        return  text.equals("/shownumbers");
    }

    void check(String data);

}
