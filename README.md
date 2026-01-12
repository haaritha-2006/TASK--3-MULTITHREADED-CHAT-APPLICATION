# TASK--3-MULTITHREADED-CHAT-APPLICATION

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: Haaritha S

*INTERN ID*: CTIS0443

*DOMAIN*: Java Programming

*DURATION*: 4 Weeks

*MENTOR*: Neela Santhosh Kumar

## Task Description

During my internship at **CODTECH IT Solutions**, I had the opportunity to build a **Multithreaded Chat Application** using Java. This project was a major milestone for me because it moved beyond simple, static programs and into the world of real-time, interactive networking. In a world where we use apps like WhatsApp, Slack, and Discord every day, I wanted to understand exactly how a server manages dozens of people talking at the same time without getting confused or crashing.

The goal was to create a digital "town square" where multiple users could connect from different locations, pick a username, and start chatting instantly. To make this work, I had to master the concept of **Multithreading**, which allows a computer to handle many tasks simultaneously. Instead of one person waiting for another to finish, the application feels alive and responsive, just like a modern professional chat platform.

---

### Key Features

1. **Concurrent Multi-User Support**
The core of this project is the ability to support many users at once. In a typical program, the computer follows a single line of logic; if it’s waiting for one user, it ignores everyone else. By using Java’s `Thread` class, I designed the server to spawn a new "handler" for every person who joins. This means the server can "listen" to ten, twenty, or even fifty people at the exact same time, giving each user a dedicated lane for their messages.
2. **Smart Message Broadcasting**
A chat room is only successful if the server knows how to relay information. I implemented a broadcasting system where the server keeps a running list of everyone currently online. When a user sends a message, the server doesn't just keep it—it instantly "broadcasts" that message to every other active connection. This ensures that when you type a message, it appears on everyone else's screen in the blink of an eye.
3. **Two-Way (Full-Duplex) Interaction**
One of the biggest challenges in networking is making sure you can send and receive data at the same time. I built the client-side with two separate threads: one that constantly watches for what you type, and another that constantly listens for new messages from the server. This **Full-Duplex** design prevents the app from "freezing" while you type, making the conversation feel natural and continuous.
4. **Automatic Connection Cleanup**
In real-world applications, people join and leave all the time. I wrote logic to handle the "lifecycle" of a connection. The server welcomes users when they arrive and, more importantly, detects when they leave (either by typing 'exit' or losing their connection). By using `finally` blocks in my code, I ensured that the server safely closes sockets and clears memory, preventing the system from becoming bogged down by "ghost" users.

---

### What I Learned

* **Network Foundations:** I gained a hands-on understanding of **TCP/IP sockets**, learning how the `ServerSocket` and `Socket` classes work together to bridge the gap between two different computers.
* **The Power of Threads:** This was my first real experience with **Concurrency**. I learned how to manage multiple threads so they work in harmony without causing "race conditions" or data errors.
* **Data Streaming:** I mastered the use of `BufferedReader` and `PrintWriter`, which taught me how to turn human thoughts into a stream of data that can travel through a network cable.
* **Problem Solving:** I learned how to debug networking issues, such as port conflicts and connection timeouts, which are essential skills for any backend or cloud engineer.
* **User Experience (UX):** Even in a console-based app, I learned that small details—like asking for a username and announcing when someone joins—make the software feel much more human and professional.

---

### Conclusion

Developing this Multithreaded Chat Application at **CODTECH IT Solutions** was an incredibly rewarding experience. It taught me that software isn't just about logic and math; it's about connecting people. By building the backend infrastructure for a real-time chat, I’ve gained a solid foundation in **Distributed Systems** and **Backend Development**.

The principles I applied here—handling connections, managing shared data, and ensuring thread safety—are the same ones used by massive companies to build global platforms. This project has given me the confidence to take on even more complex networking challenges, like building secure file-transfer tools or even the backend for a multiplayer game. It was a meaningful step forward in my journey to becoming a professional software engineer.

#OUTPUT
<img width="1688" height="656" alt="Image" src="https://github.com/user-attachments/assets/d7b5aa41-4ce1-4a66-b87d-51a29a85fe91" />
