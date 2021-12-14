# JavaNews TelegramBot
News for Java developer in Telegram.
[Bot link](https://t.me/test_vliloks_javanews_bot)

![alt tag](https://i.ibb.co/tMHD0Bp/chat-bot-featured-1240x580.jpg "image")​

## Idea
Make a bot that will notify everyone about new news from the groups which they are subscribed.

# How it works 
Bot regularly checks for new articles in the JavaRush groups, that you subscribed, and makes distribution.

### Features implemented in the JavaNews TelegramBot:
- User can subscribe on group of posts
- User can view list of group subscriptions on which user subscribes
- User can unsubscribe from group of posts
- User can set an inactive bot and do not receive notifications
- User can restart getting notifications
- Administration can get statistics

# Technological stack
- SpringBoot as a skeleton framework
- Spring Scheduler as a task manager
- MySQL database as a database for saving user and subscription info
- Flyway database migration tool
- Telegram-bot SpringBoot starter
- Spring Data starter
- Unirest - lib for working with REST calls

### Deployment
Bot deployed on a cloud service Heroku.