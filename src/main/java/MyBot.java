import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot implements TelegramBotUtils{
    private String chatId;
    private String message="hi there i'm an k-pop idol";

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasCallbackQuery()){
            System.out.println("asdfghj");
            this.chatId=String.valueOf(update.getCallbackQuery().getMessage().getChatId());
            String data=update.getCallbackQuery().getData();

            switch (data) {
                case "01" -> {
                    this.message = "u entered 1 " + data;
                    execute(this.message,this.chatId);
                }
                case "11" -> {
                    this.message = "u entered 2 " + data;
                    execute(this.message, this.chatId);
                }
                case "21" -> {
                    this.message = "u entered 3 " + data;
                    execute(this.message, this.chatId);
                }
                case "31" -> {
                    this.message = "u entered 4 " + data;
                    execute(this.message, this.chatId);
                }
                case "41" -> {
                    this.message = "u entered 5 " + data;
                    execute(this.message, this.chatId);
                }
                case "51" -> {
                    this.message = "u entered 6 " + data;
                    execute(this.message, this.chatId);
                }
                case "61" -> {
                    this.message = "u entered 77" + data;
                    execute(this.message, this.chatId);
                }
                case "71" -> {
                    this.message = "u entered 8 " + data;
                    execute(this.message, this.chatId);
                }
                case "81" -> {
                    this.message = "u entered 9 " + data;
                    execute(this.message, this.chatId);
                }
            }
        }

        else if (update.hasMessage()){

            this.chatId=String.valueOf(update.getMessage().getChatId());
            String text=update.getMessage().getText();
//            if (isStart(text)) {
//                execute(true);
//            }
//            else if(areMyCards(text)){
//                execute(false);
//            }

            TelegramBotUtils telegramBotUtils= data ->{
                if (data.equals("/start")){
                   execute1(menu(),null);
                }else if(data.equals("/shownumbers")){
                    execute1(null, getBtn());
                }
            };
            telegramBotUtils.check(text);
        }
    }
    private void execute(String message,String chatId){
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void execute1(ReplyKeyboardMarkup r, InlineKeyboardMarkup i){
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(this.chatId);
        sendMessage.setText(this.message);
        sendMessage.setReplyMarkup(i==null? r:i);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private ReplyKeyboardMarkup menu(){
        ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows=new ArrayList<>();
        keyboardMarkup.setKeyboard(keyboardRows);
        KeyboardRow keyboardRow=new KeyboardRow();
        keyboardRow.add("Kartalarim");
        KeyboardRow keyboardRow1=new KeyboardRow();
        keyboardRow1.add("To'lov");
        keyboardRow1.add("Balance");
        KeyboardRow keyboardRow2=new KeyboardRow();
        keyboardRow2.add("P2P");
        keyboardRow2.add("History");
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        return keyboardMarkup;
    }

    private InlineKeyboardMarkup getBtn(){
        InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> list=new ArrayList<>();
        inlineKeyboardMarkup.setKeyboard(list);

        List<InlineKeyboardButton> inlineKeyboardButtons=new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            InlineKeyboardButton inlineKeyboardButton=new InlineKeyboardButton();
            inlineKeyboardButton.setText(i+1+"");
            inlineKeyboardButton.setCallbackData(String.valueOf(i+"1"));
            inlineKeyboardButtons.add(inlineKeyboardButton);

            if ((i+1)%3==0){
                list.add(inlineKeyboardButtons);
                inlineKeyboardButtons=new ArrayList<>();
            }
        }
        return inlineKeyboardMarkup;
    }

    @Override
    public void check(String data) {
    }
}
