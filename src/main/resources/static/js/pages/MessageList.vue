<template>
    <v-container>
        <v-layout align-space-around justify-start column>
            <message-form :messageAttr="message" />
            <message-row v-for="message in sortedMessages"
                         :key="message.id"
                         :message="message"
                         :editMessage="editMessage"
                         :deleteMessage="deleteMessage" />
            <lazy-loader></lazy-loader>
        </v-layout>
    </v-container>
</template>

<script>
    import { mapGetters } from 'vuex'
    import MessageRow from 'components/messages/MessageRow.vue'
    import MessageForm from 'components/messages/MessageForm.vue'
    import messagesApi from 'api/messages'
    import LazyLoader from '../components/LazyLoader.vue'
    export default {
        components: {
            LazyLoader,
            MessageRow,
            MessageForm
        },
        data() {
            return {
                message: null
            }
        },
        computed: mapGetters(['sortedMessages']),
        methods: {
            editMessage(message) {
                this.message = message
            },
            deleteMessage(message) {
                messagesApi.remove(message.id).then(result => {
                    if (result.ok) {
                        const index = this.messages.indexOf(message)
                        if(index > -1){
                            this.messages.splice(index, 1)
                        }
                    }
                })
            }
        }
    }
</script>

<style>
</style>