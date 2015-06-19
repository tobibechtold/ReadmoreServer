# ReadmoreServer
RESTful API to get the forum contents of german esport website readmore.de

# Usage
The restlet runs on port 8182 and currently has three different restlets to retrieve the forums, the threads and the posts.

```/forum``` no paramters will give you all forums 

```/threads?&categoryId=x&forenId=y``` will give you all the threads in the forum with forumId y and categoryId x

```/beitrag?&categoryId=91&forenId=10&threadId=138676&seite=1``` will give you page 1 of thread #138676. You also have to specify in which category and in which forum your desired thread is

All the responses from the server are JSON Strings. For example the JSON object for a thread will look like this:

```
{"titel":"Neue leise Graka fuer Witcher 3","id":138423,"forumId":10,"anzahlSeiten":2}
```

As you are requesting all the threads you will get a JSONArray of all threads in the forum in the format you can see above.
Posts from users will also come in a JSONArray in this format:
```
{"id":0,"threadId":0,"inhalt":"office Liste reicht locker. Crucial BX100 dazu und den 
günstigsten Brenner von LG, Liteon oder 
Samsung\r\n\r\nob das budget eine SSD hergibt wissen nur du und deine Eltern",
"ersteller":{"id":86862,"anzeigename":"tob1","avatar":"https://cdn0.readmore.de
/user_pictures/86000/86862/100.jpg?1407891127","alter":0}}
```


