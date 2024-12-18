package com.example.server_9dokme.Notification.SSE;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class EmitterRepositoryImpl {

    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();
    private final Map<String , Object> eventCache = new ConcurrentHashMap<>();

    public SseEmitter save(String emitteId, SseEmitter sseEmitter) {
        emitters.put(emitteId, sseEmitter);
        return sseEmitter;
    }

    public void saveEventCache(String emitteId, Object event) {
        eventCache.put(emitteId, event);
    }

    public Map<String, SseEmitter> findAllEmitterStartWithByMemberId(String memberId) {
        return emitters.entrySet().stream()
                .filter(entry->entry.getKey().startsWith(memberId))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    public Map<String, Object> findAllEventCacheStartWithByMemberId(String memberId) {
        return eventCache.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith(memberId))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    public void delete(String emitteId) {
        emitters.remove(emitteId);
    }

    public void deleteAllEmitterStartWithId(String memberId) {
        emitters.forEach(
                (key,emitter)->{
                    if(key.startsWith(memberId)){
                        emitters.remove(key);
                    }
                }
        );
    }

    public void deleteAllEventCacheStartWithId(String memberId) {
        eventCache.forEach(
                (key,value)->{
                    if(key.startsWith(memberId)){
                        eventCache.remove(key);
                    }
                }
        );
    }
}
